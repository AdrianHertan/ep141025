package usarb.web.ep.type;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type createType(TypeDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("Type ID must be null when creating a new type");
        }

        Type type = new Type();
        type.setName(dto.getName());
        type.setDescription(dto.getDescription());
        type.setBasePrice(dto.getBasePrice());

        return typeRepository.save(type);
    }

    public void deleteType(Integer id) {
        if (typeRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Type not found by id=" + id);
        }
        typeRepository.deleteById(id);
    }

    @Transactional
    public void updateType(Integer id, TypeDTO dto) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Type not found by id=" + id));

        if (dto.getName() != null && !dto.getName().isEmpty()) type.setName(dto.getName());
        if (dto.getDescription() != null && !dto.getDescription().isEmpty()) type.setDescription(dto.getDescription());
        if (dto.getBasePrice() != null) type.setBasePrice(dto.getBasePrice());
    }
}
