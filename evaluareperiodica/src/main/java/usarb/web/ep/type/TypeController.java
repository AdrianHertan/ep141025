package usarb.web.ep.type;

import usarb.web.ep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<Type> getAllTypes() {
        return typeService.getAllTypes();
    }

    @PostMapping
    public Type createType(@RequestBody TypeDTO typeDTO) {
        return typeService.createType(typeDTO);
    }

    @DeleteMapping("/{typeId}")
    public void deleteType(@PathVariable Integer typeId) {
        typeService.deleteType(typeId);
    }

    @PutMapping("/{typeId}")
    public void updateType(
            @PathVariable Integer typeId,
            @RequestBody TypeDTO typeDTO
    ) {
        typeService.updateType(typeId, typeDTO);
    }
}
