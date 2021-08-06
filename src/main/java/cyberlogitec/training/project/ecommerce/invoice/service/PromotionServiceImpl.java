package cyberlogitec.training.project.ecommerce.invoice.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.dto.invoice.CreatePromotionDto;
import cyberlogitec.training.project.ecommerce.invoice.model.Promotion;
import cyberlogitec.training.project.ecommerce.invoice.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionServiceImpl extends GenericService<Promotion, Long> implements PromotionService {
    private PromotionRepository repository;

    @Override
    public Promotion save(CreatePromotionDto dto) {
        Promotion promotion = new Promotion();
        promotion.setCode(RandomStringUtils.randomAlphanumeric(8));
        promotion.setName(dto.getName());
        promotion.setDiscountPrice(dto.getPriceDiscount());
        promotion.setMaxPrice(dto.getMaxPrice());
        promotion.setPercentageDiscount(dto.getPercentageDiscount());
        return repository.save(promotion);
    }

    @Override
    public Promotion update(CreatePromotionDto dto, String code) {
        Promotion promotion = repository.findByCode(code);
        if(promotion == null)
            return null;
        promotion.setName(dto.getName());
        promotion.setDiscountPrice(dto.getPriceDiscount());
        promotion.setMaxPrice(dto.getMaxPrice());
        promotion.setPercentageDiscount(dto.getPercentageDiscount());
        return repository.save(promotion);
    }

    @Override
    public Promotion deleteByCode(String code) {
        Promotion promotion = repository.findByCode(code);
        if(promotion == null)
            return null;
        repository.deleteByCode(code);
        return promotion;
    }
}
