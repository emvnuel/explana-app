package io.github.emvnuel.explanaapp.repository.impl;

import com.mongodb.DBObject;
import io.github.emvnuel.explanaapp.model.Review;
import io.github.emvnuel.explanaapp.repository.ReviewCustomRepository;
import io.github.emvnuel.explanaapp.repository.projections.SalaryStatistic;
import org.bson.types.Decimal128;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {

    private final MongoTemplate template;

    public ReviewCustomRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }

    @Override
    public BigDecimal avgSalaryByCompany(String companyId) {
        TypedAggregation<Review> agg =
                newAggregation(
                        Review.class,
                        match(Criteria.where("companyId").is(companyId)),
                        group("companyId").avg("salary").as("avgSalary")
                );

        AggregationResults<DBObject> result = template.aggregate(agg, DBObject.class);
        DBObject resultList = result.getUniqueMappedResult();

        if (resultList == null)
            return BigDecimal.ZERO;

        return ((Decimal128) resultList.get("avgSalary")).bigDecimalValue();
    }

    @Override
    public List<SalaryStatistic> avgSalariesByCompany(String companyId) {
        TypedAggregation<Review> agg =
                newAggregation(
                        Review.class,
                        match(Criteria.where("companyId").is(companyId)),
                        group("job", "jobLevel").avg("salary").as("avgSalary").count().as("total"),
                        project("_id.job", "_id.jobLevel", "avgSalary", "total").andExclude("_id")
                );

        AggregationResults<SalaryStatistic> result = template.aggregate(agg, SalaryStatistic.class);
        List<SalaryStatistic> resultList = result.getMappedResults();

        if (resultList == null)
            return new ArrayList<>();

        return resultList;
    }

    @Override
    public Double avgRatingByCompany(String companyId) {
        TypedAggregation<Review> agg =
                newAggregation(
                        Review.class,
                        match(Criteria.where("companyId").is(companyId)),
                        group("companyId").avg("rating").as("avgRating")
                );

        AggregationResults<DBObject> result = template.aggregate(agg, DBObject.class);
        DBObject resultList = result.getUniqueMappedResult();

        if (resultList == null)
            return 5.0;

        return (Double) resultList.get("avgRating");
    }

}
