package com.NoPlan.Phama.api;


import com.NoPlan.Phama.dto.request.UserRequestDto;

import com.NoPlan.Phama.service.UserService;
import com.NoPlan.Phama.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/create" ) // localhost:8000/api/v1/user/create (POST)
    public ResponseEntity<StandardResponse> save(@RequestBody UserRequestDto dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        userService.saveUser(dto),
                        null

                ), HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}") // localhost:8000/api/v1/user/15 (GET)
    public ResponseEntity<StandardResponse> find(@PathVariable String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                        id+" Details!",
                        userService.findUser(id)

                ), HttpStatus.OK
        );
    }

    @PutMapping(value = "/modify",params = {"id"}) // localhost:8000/api/v1/user/modify?id=15 (PUT)
    public ResponseEntity<StandardResponse> updateUser(@RequestBody UserRequestDto dto, @RequestParam String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        userService.updateUser(dto,id),
                        null

                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/remove/{id}") // localhost:8000/api/v1/user/remove/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        204 ,
                        userService.deleteUser(id),
                        null

                ), HttpStatus.NO_CONTENT
        );
    }
    // api/v1/user/list?searchText=sd&page=1&size=10
    @GetMapping(value = "/list", params = {"searchText","page","size"}) // localhost:8000/api/v1/user/list (GET)
    public ResponseEntity<StandardResponse> findAllUser(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200 ,
                       "Data list",
                        userService.findAllUser(searchText,page,size)

                ), HttpStatus.OK
        );

    }
}
