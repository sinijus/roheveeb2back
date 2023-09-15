package ee.valiit.roheveeb2back.domain.order.transport;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderTransportService {

    @Resource
    private TransportRepository transportRepository;

    public Transport getTransportBy(Integer transportId) {
        Optional<Transport> transportOptional = transportRepository.findById(transportId);
        return transportOptional.orElseGet(null);
    }
}
