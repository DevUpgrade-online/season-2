package online.devupgrade.sezon2.utilshelpers;

import online.devupgrade.sezon2.entities.DiscountEntity;
import online.devupgrade.sezon2.entities.Product;
import online.devupgrade.sezon2.helper.IVisitor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DiscountedPriceSumCalculator implements IVisitor {

    final public SumProvider sumMantisa = new SumProvider();

    @Override
    public Optional<Boolean> visit(List<Product> products, Optional<Map<String, Object>> params) {
        sumMantisa.reset();
        products.forEach(
                product ->
                {
                    List<DiscountEntity> discountEntities = null;
                    if (params.isPresent()){
                        discountEntities = (List<DiscountEntity>) params.get().get("discount");
                    }
                    if(discountEntities != null && !discountEntities.isEmpty()) {
                        discountEntities.stream().forEach(
                                discountEntity -> {
                                    if(discountEntity.getIncluded() != null && !discountEntity.getIncluded().isEmpty()) {
                                        if (discountEntity.getIncluded().stream().anyMatch( a -> a.id == product.id) ) {
                                            sumMantisa.add(product.getPrice() - ((product.getPrice() * discountEntity.getValue()) / 100 ));
                                        } else {
                                            sumMantisa.add(product.getPrice());
                                        }
                                    } else {
                                        if(discountEntity.getExcluded() != null && !discountEntity.getExcluded().isEmpty()) {
                                            if (discountEntity.getExcluded().stream().filter( a -> a.id == product.id).findFirst().isPresent() ) {
                                                if( discountEntity.getExcluded().stream().filter( a -> a.id == product.id).findFirst().get().id
                                                        == product.id) {
                                                    //nic nie rob
                                                } else {
                                                    sumMantisa.add(product.getPrice());

                                                }
                                            } else {
                                                sumMantisa.add(product.getPrice() - ((product.getPrice() * discountEntity.getValue()) / 100 ));
                                            }
                                        } else {
                                            sumMantisa.add(product.getPrice() - ((product.getPrice() * discountEntity.getValue()) / 100 ));
                                        }
                                    }
                                }
                        );
                    } else {
                        sumMantisa.add(product.getPrice());
                    }


                }
        );
        Float sum = sumMantisa.sum;
        return sum >= 0f ? Optional.of(Boolean.TRUE) : Optional.empty();
    }

}
