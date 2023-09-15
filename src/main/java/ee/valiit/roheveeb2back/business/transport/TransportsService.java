package ee.valiit.roheveeb2back.business.transport;

import ee.valiit.roheveeb2back.domain.order.transport.OrderTransportService;
import ee.valiit.roheveeb2back.domain.order.transport.Transport;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportsService {

    @Resource
    private OrderTransportService orderTransportService;

    public List<Transport> getTransportInfo() {
        return orderTransportService.getTransportInfo();
    }
}
