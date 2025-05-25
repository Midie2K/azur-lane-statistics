package com.midie2k.azur_lane_statistics.services;


import com.midie2k.azur_lane_statistics.services.filtration.filters.RangeFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.StringFilter;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class QueryService<T> {

    protected <X extends Comparable<? super X>> Specification<T> buildRangeSpecification(
            RangeFilter<X> filter,
            SingularAttribute<? super T, X> field
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getEquals() != null) {
                predicates.add(cb.equal(root.get(field), filter.getEquals()));
            }
            if (filter.getNotEquals() != null) {
                predicates.add(cb.notEqual(root.get(field), filter.getNotEquals()));
            }
            if (filter.getIn() != null && !filter.getIn().isEmpty()) {
                predicates.add(root.get(field).in(filter.getIn()));
            }
            if (filter.getNotIn() != null && !filter.getNotIn().isEmpty()) {
                predicates.add(cb.not(root.get(field).in(filter.getNotIn())));
            }
            if (filter.getGreaterThan() != null) {
                predicates.add(cb.greaterThan(root.get(field), filter.getGreaterThan()));
            }
            if (filter.getLessThan() != null) {
                predicates.add(cb.lessThan(root.get(field), filter.getLessThan()));
            }
            if (filter.getGreaterThanOrEqual() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get(field), filter.getGreaterThanOrEqual()));
            }
            if (filter.getLessThanOrEqual() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get(field), filter.getLessThanOrEqual()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    protected Specification<T> buildStringSpecification(
            StringFilter filter,
            SingularAttribute<? super T, String> field
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.getEquals() != null) {
                predicates.add(cb.equal(cb.lower(root.get(field)), filter.getEquals().toLowerCase()));
            }
            if (filter.getNotEquals() != null) {
                predicates.add(cb.notEqual(cb.lower(root.get(field)), filter.getNotEquals().toLowerCase()));
            }
            if (filter.getIn() != null && !filter.getIn().isEmpty()) {
                Set<String> lowered = filter.getIn().stream().map(String::toLowerCase).collect(java.util.stream.Collectors.toSet());
                predicates.add(root.get(field).in(lowered));
            }
            if (filter.getNotIn() != null && !filter.getNotIn().isEmpty()) {
                Set<String> lowered = filter.getNotIn().stream().map(String::toLowerCase).collect(java.util.stream.Collectors.toSet());
                predicates.add(cb.not(root.get(field).in(lowered)));
            }
            if (filter.getContains() != null) {
                predicates.add(cb.like(cb.lower(root.get(field)), "%" + filter.getContains().toLowerCase() + "%"));
            }
            if (filter.getNotContains() != null) {
                predicates.add(cb.notLike(cb.lower(root.get(field)), "%" + filter.getNotContains().toLowerCase() + "%"));
            }
            if (filter.getStartsWith() != null) {
                predicates.add(cb.like(cb.lower(root.get(field)), filter.getStartsWith().toLowerCase() + "%"));
            }
            if (filter.getNotStartsWith() != null) {
                predicates.add(cb.notLike(cb.lower(root.get(field)), filter.getNotStartsWith().toLowerCase() + "%"));
            }
            if (filter.getEndsWith() != null) {
                predicates.add(cb.like(cb.lower(root.get(field)), "%" + filter.getEndsWith().toLowerCase()));
            }
            if (filter.getNotEndsWith() != null) {
                predicates.add(cb.notLike(cb.lower(root.get(field)), "%" + filter.getNotEndsWith().toLowerCase()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    protected Specification<T> buildInstantSpecification(
            RangeFilter<Instant> filter,
            SingularAttribute<? super T, Instant> field
    ) {
        return buildRangeSpecification(filter, field);
    }
}