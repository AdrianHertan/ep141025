package usarb.web.ep.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usarb.web.ep.rabbit.Rabbit;
import usarb.web.ep.rabbit.RabbitDTO;
import usarb.web.ep.rabbit.RabbitService;


import java.util.List;

@RestController
@RequestMapping("/rabbits")
public class RabbitController {

    private final RabbitService rabbitService;

    @Autowired
    public RabbitController(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }

    @GetMapping
    public List<Rabbit> getAllRabbits() {
        return rabbitService.getAllRabbits();
    }

    @PostMapping
    public Rabbit createRabbit(@RequestBody RabbitDTO rabbitDTO) {
        return rabbitService.createRabbit(rabbitDTO);
    }

    @DeleteMapping("/{rabbitId}")
    public void deleteRabbit(@PathVariable Integer rabbitId) {
        rabbitService.deleteRabbit(rabbitId);
    }

    @PutMapping("/{rabbitId}")
    public void updateRabbit(
            @PathVariable Integer rabbitId,
            @RequestBody RabbitDTO rabbitDTO
    ) {
        rabbitService.updateRabbit(rabbitId, rabbitDTO);
    }
}
