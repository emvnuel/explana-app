package io.github.emvnuel.explanaapp.repository;

import com.mongodb.DBObject;
import io.github.emvnuel.explanaapp.model.Review;
import org.bson.types.Decimal128;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.math.BigDecimal;

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
