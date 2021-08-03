package cyberlogitec.training.project.ecommerce.invoice.service;

import cyberlogitec.training.project.ecommerce.common.IGenericService;
import cyberlogitec.training.project.ecommerce.dto.invoice.CreatePromotionDto;
import cyberlogitec.training.project.ecommerce.invoice.model.Promotion;

public interface PromotionService extends IGenericService<Promotion, Long> {
    public Promotion save(CreatePromotionDto dto);
}
