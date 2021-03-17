package com.example.flight;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AirportController {

    private final AirportRepository repository;

    private AirportController(AirportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/airports")
    public List<Airport> all() {
        return repository.findAll();
    }

    @PostMapping("/airports")
    public Airport newEmployee(@RequestBody Airport newAirport) {
        return repository.save(newAirport);
    }

    @GetMapping("/airports/{id}")
    public Airport one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException(id));
    }

    @PutMapping("/airports/{id}")
    public Airport replaceEmployee(@RequestBody Airport newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.set_name(newEmployee.get_name());
                    employee.set_airportCode(newEmployee.get_airportCode());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/airports/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}