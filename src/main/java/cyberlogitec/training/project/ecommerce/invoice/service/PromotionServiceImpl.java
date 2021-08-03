package cyberlogitec.training.project.ecommerce.invoice.service;

import cyberlogitec.training.project.ecommerce.common.GenericService;
import cyberlogitec.training.project.ecommerce.dto.invoice.CreatePromotionDto;
import cyberlogitec.training.project.ecommerce.invoice.model.Promotion;
import cyberlogitec.training.project.ecommerce.invoice.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PromotionServiceImpl extends GenericService<Promotion, Long> implements PromotionService {
    private PromotionRepository repository;

    @Override
    public Promotion save(CreatePromotionDto dto) {
        return null;
    }
}
