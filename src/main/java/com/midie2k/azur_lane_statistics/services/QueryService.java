package com.midie2k.azur_lane_statistics.services;


import com.midie2k.azur_lane_statistics.services.filtration.filters.RangeFilter;
import com.midie2k.azur_lane_statistics.services.filtration.filters.StringFilter;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class QueryService<T> {

    protected <X extends Comparable<? super X>> Specification<T> buildRangeSpecification(
            RangeFilter<X> filter,
            SingularAttribute<? super T, X> field
    ) {
        return buildRangeSpecification(filter, root -> root.get(field));
    }

    protected <X extends Comparable<? super X>> Specification<T> buildRangeSpecification(
            RangeFilter<X> filter,
            Function<Root<T>, Expression<X>> metaclassFunction
    ) {
        return (root, query, cb) -> {
            Expression<X> expression = metaclassFunction.apply(root);
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getEquals() != null) predicates.add(cb.equal(expression, filter.getEquals()));
            if (filter.getNotEquals() != null) predicates.add(cb.notEqual(expression, filter.getNotEquals()));
            if (filter.getIn() != null && !filter.getIn().isEmpty()) predicates.add(expression.in(filter.getIn()));
            if (filter.getNotIn() != null && !filter.getNotIn().isEmpty())
                predicates.add(cb.not(expression.in(filter.getNotIn())));
            if (filter.getGreaterThan() != null) predicates.add(cb.greaterThan(expression, filter.getGreaterThan()));
            if (filter.getLessThan() != null) predicates.add(cb.lessThan(expression, filter.getLessThan()));
            if (filter.getGreaterThanOrEqual() != null)
                predicates.add(cb.greaterThanOrEqualTo(expression, filter.getGreaterThanOrEqual()));
            if (filter.getLessThanOrEqual() != null)
                predicates.add(cb.lessThanOrEqualTo(expression, filter.getLessThanOrEqual()));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    protected Specification<T> buildStringSpecification(
            StringFilter filter,
            SingularAttribute<? super T, String> field
    ) {
        return buildStringSpecification(filter, root -> root.get(field));
    }

    protected Specification<T> buildStringSpecification(
            StringFilter filter,
            Function<Root<T>, Expression<String>> metaclassFunction
    ) {
        return (root, query, cb) -> {
            Expression<String> expression = cb.lower(metaclassFunction.apply(root));
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getEquals() != null)
                predicates.add(cb.equal(expression, filter.getEquals().toLowerCase()));
            if (filter.getNotEquals() != null)
                predicates.add(cb.notEqual(expression, filter.getNotEquals().toLowerCase()));
            if (filter.getIn() != null && !filter.getIn().isEmpty()) {
                Set<String> lowered = filter.getIn().stream().map(String::toLowerCase).collect(java.util.stream.Collectors.toSet());
                predicates.add(expression.in(lowered));
            }
            if (filter.getNotIn() != null && !filter.getNotIn().isEmpty()) {
                Set<String> lowered = filter.getNotIn().stream().map(String::toLowerCase).collect(java.util.stream.Collectors.toSet());
                predicates.add(cb.not(expression.in(lowered)));
            }
            if (filter.getContains() != null)
                predicates.add(cb.like(expression, "%" + filter.getContains().toLowerCase() + "%"));
            if (filter.getNotContains() != null)
                predicates.add(cb.notLike(expression, "%" + filter.getNotContains().toLowerCase() + "%"));
            if (filter.getStartsWith() != null)
                predicates.add(cb.like(expression, filter.getStartsWith().toLowerCase() + "%"));
            if (filter.getNotStartsWith() != null)
                predicates.add(cb.notLike(expression, filter.getNotStartsWith().toLowerCase() + "%"));
            if (filter.getEndsWith() != null)
                predicates.add(cb.like(expression, "%" + filter.getEndsWith().toLowerCase()));
            if (filter.getNotEndsWith() != null)
                predicates.add(cb.notLike(expression, "%" + filter.getNotEndsWith().toLowerCase()));

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    protected Specification<T> buildInstantSpecification(
            RangeFilter<Instant> filter,
            SingularAttribute<? super T, Instant> field
    ) {
        return buildRangeSpecification(filter, field);
    }

    protected Specification<T> buildInstantSpecification(
            RangeFilter<Instant> filter,
            Function<Root<T>, Expression<Instant>> metaclassFunction
    ) {
        return buildRangeSpecification(filter, metaclassFunction);
    }
}
