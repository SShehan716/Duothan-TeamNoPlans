package com.NoPlan.Phama.api;


import com.NoPlan.Phama.dto.request.DrugRequestDto;
import com.NoPlan.Phama.service.DrugService;
import com.NoPlan.Phama.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pharmacy")
public class PharmacyController {
    @Autowired
    private DrugService drugService;

    @PostMapping(value="/create" ) // localhost:8000/api/v1/drug/create (POST)
    public ResponseEntity<StandardResponse> save(@RequestBody DrugRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        drugService.saveDrug(dto),
                        null

                ), HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}") // localhost:8000/api/v1/drug/15 (GET)
    public ResponseEntity<StandardResponse> find(@PathVariable String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                        id+" Details!",
                        drugService.findDrug(id)

                ), HttpStatus.OK
        );
    }

    @PutMapping(value = "/modify",params = {"id"}) // localhost:8000/api/v1/drug/modify?id=15 (PUT)
    public ResponseEntity<StandardResponse> updateDrug(@RequestBody DrugRequestDto dto, @RequestParam String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        drugService.updateDrug(dto,id),
                        null

                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/remove/{id}") // localhost:8000/api/v1/drug/remove/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteDrug(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        204 ,
                        drugService.deleteDrug(id),
                        null

                ), HttpStatus.NO_CONTENT
        );
    }
    // api/v1/drug/list?searchText=sd&page=1&size=10
    @GetMapping(value = "/list", params = {"searchText","page","size"}) // localhost:8000/api/v1/drug/list (GET)
    public ResponseEntity<StandardResponse> findAllDrug(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                       "Data list",
                        drugService.findAllDrug(searchText,page,size)

                ), HttpStatus.OK
        );

    }
}
