package com.theodean.oxbackend.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SolverController {
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/solver")
    public Solver solver(@RequestParam(value="grid") String grid){
        Solver solver = new Solver(grid);
        try {
            solver.solve();
        } catch (Exception e){
            e.printStackTrace();
        }
        return new Solver(grid, solver.getMove());
    }
}
