package usarb.web.ep.rabbit;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usarb.web.ep.type.TypeRepository;

import usarb.web.ep.type.Type;

import java.util.List;


@Service
public class RabbitService {

    private final RabbitRepository rabbitRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public RabbitService(RabbitRepository rabbitRepository, TypeRepository typeRepository) {
        this.rabbitRepository = rabbitRepository;
        this.typeRepository = typeRepository;
    }

    public List<Rabbit> getAllRabbits() {
        return rabbitRepository.findAll();
    }

    public Rabbit createRabbit(RabbitDTO dto) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("Rabbit ID must be null when creating a new rabbit");
        }

        Type type = typeRepository.findById(dto.getTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Type not found by id=" + dto.getTypeId()));

        Rabbit rabbit = new Rabbit();
        rabbit.setName(dto.getName());
        rabbit.setAge(dto.getAge());
        rabbit.setWeight(dto.getWeight());
        rabbit.setPrice(dto.getPrice() != null ? dto.getPrice() : type.getBasePrice());
        rabbit.setType(type);

        return rabbitRepository.save(rabbit);
    }

    public void deleteRabbit(Integer id) {
        if (!rabbitRepository.existsById(id)) {
            throw new IllegalArgumentException("Rabbit not found by id=" + id);
        }
        rabbitRepository.deleteById(id);
    }

    @Transactional
    public void updateRabbit(Integer id, RabbitDTO dto) {
        Rabbit rabbit = rabbitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Rabbit not found by id=" + id));

        if (dto.getName() != null && !dto.getName().isEmpty()) rabbit.setName(dto.getName());
        if (dto.getAge() != null) rabbit.setAge(dto.getAge());
        if (dto.getWeight() != null) rabbit.setWeight(dto.getWeight());
        if (dto.getPrice() != null) rabbit.setPrice(dto.getPrice());

        if (dto.getTypeId() != null) {
            Type type = typeRepository.findById(dto.getTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("Type not found by id=" + dto.getTypeId()));
            rabbit.setType(type);
        }

        rabbitRepository.save(rabbit);
    }
}
