package com.dbd.realstate.controllers;

import com.dbd.realstate.RealStateExcepction;
import com.dbd.realstate.model.Employee;
import com.dbd.realstate.model.RealState;
import com.dbd.realstate.services.RealStatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api_rs")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RealStatesController {

    @Autowired
    private RealStatesService service;

    /*
    Endpoint de prueba, puede utilizarlo para confirmar el correcto funcionamiento
     */
    @GetMapping(path = "/prueba")
    public String prueba() {
        return "OK";
    }

    /*
    POST /realstate
    Recibe en el body un objeto Real State y lo persiste en la base de datos
    Ejemplo:
    {
        "name": "Inmobiliaria 2",
        "cuil": "30207867861",
        "number": "542345656565",
        "address": "Calle 3 n890"
    }
     */
    @PostMapping(path = "/realstate")
    public RealState createRealState(@RequestBody RealState realState) throws RealStateExcepction {
        return this.service.createRealState(realState);
    }

    /*
    GET /realstate/{id}
    Obtiene los datos de la Real State con id indicado en la URL
     */
    @GetMapping(path = "/realstate/{id}")
    public RealState getRealState(@PathVariable Long id) throws RealStateExcepction {
        return this.service.getRealState(id);
    }

    /*
    PUT /realstate
    Actualiza los datos de una Real State, debe contener todos los datos de esta.
    Ejemplo:
    {
        "name": "Inmobiliaria 2",
        "cuil": "30207867861",
        "number": "542345656565",
        "address": "Calle 3 n880",
        "numberOfEmployees": 0,
    }
     */
    @PutMapping(path = "/realstate/{id}")
    public RealState updateRealState(@RequestBody RealState realState, @PathVariable Long id) throws RealStateExcepction{
        return this.service.updateRealState(realState,id);
    }
     /*
     POST /employee
     Recibe en el body un objeto Employee y lo persiste en la base de datos
     Ejemplo:
     {
        "fullname": "Empleado 1",
        "dni": "23000000",
        "calification": 10,
        "realState": {
            "id": 1,
            "name": "Inmobiliaria 2",
            "cuil": "30207867861",
            "number": "542345656565",
            "address": "Calle 3 n890",
            "numberOfEmployees": 0,
            "propertyList": null
        }
      }
      La Real State a la que este asociada el empleado debe haberse creado con anterioridad
      */
    @PostMapping(path = "/employee")
    public Employee createEmployee(@RequestBody Employee employee) throws RealStateExcepction {
        return this.service.createEmployee(employee);
    }

    /*
    GET /employee/dni/{dni}
    Obtiene los datos del Employee con dni indicado en la URL
     */
    @GetMapping(path = "/employee/dni/{dni}")
    public Employee getEmployeeByDni(@PathVariable String dni) throws RealStateExcepction {
        return this.service.employeeWithDni(dni);
    }

    @DeleteMapping(path = "/employee/{id}")
    public boolean deleteEmployee(@PathVariable Long id) throws RealStateExcepction {
        return this.service.deleteEmployee(id);
    }

    @GetMapping(path = "/employee/calification/{number}")
    public List<Employee> getEmployeesWithCalificationGreatherThan(@PathVariable int calification) throws RealStateExcepction {
        return this.service.employeesWithCalificationGreatherThan(calification);
    }


}
