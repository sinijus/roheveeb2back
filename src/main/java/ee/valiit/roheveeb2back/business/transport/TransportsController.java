package ee.valiit.roheveeb2back.business.transport;

import ee.valiit.roheveeb2back.domain.order.transport.Transport;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransportsController {

    @Resource
    private TransportsService transportsService;

    @GetMapping("/transports")
    @Operation(summary = "toob ära transpordiga seotud info", description = "toob ära transpordiga seotud info")
    public List<Transport> getTransportInfo() {
        return transportsService.getTransportInfo();
    }

}
