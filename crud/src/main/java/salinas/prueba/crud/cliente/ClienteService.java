package salinas.prueba.crud.cliente;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import salinas.prueba.crud.cliente.Cliente;

@Service
public class ClienteService {

    private Map<Long, Cliente> repository = Arrays.asList(
                    new Cliente[]{
                            new Cliente(1, "Alan","Turing"),
                            new Cliente(2, "Sebastian","Bach"),
                            new Cliente(3, "Pablo","Picasso"),
                    }).stream()
            .collect(Collectors.toConcurrentMap(s -> s.getId(), Function.identity()));

    // DB id sequence mock
    private AtomicLong sequence = new AtomicLong(3);

    public List<Cliente> readAll() {
        return repository.values().stream().collect(Collectors.toList());
    }

    public Cliente read(Long id) {
        return repository.get(id);
    }

    public Cliente create(Cliente student) {
        long key = sequence.incrementAndGet();
        student.setId(key);
        repository.put(key, student);
        return student;
    }

    public Cliente update(Long id, Cliente student) {
        student.setId(id);
        Cliente oldStudent = repository.replace(id, student);
        return oldStudent == null ? null : student;
    }

    public void delete(Long id) {
        repository.remove(id);
    }

}
