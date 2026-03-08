package com.example.datasetapi.controller;

import com.example.datasetapi.model.DatasetRecord;
import com.example.datasetapi.service.DatasetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dataset")
public class DatasetController {

    private final DatasetService service;

    public DatasetController(DatasetService service) {
        this.service = service;
    }

    @PostMapping("/{datasetName}/record")
    public DatasetRecord addRecord(@PathVariable String datasetName,
                                   @RequestBody DatasetRecord record) {

        return service.saveRecord(datasetName, record);
    }

    @GetMapping("/{datasetName}/query")
    public Object queryDataset(@PathVariable String datasetName,
                               @RequestParam(required = false) String groupBy,
                               @RequestParam(required = false) String sortBy) {

        if ("department".equals(groupBy)) {
            return service.groupByDepartment(datasetName);
        }

        if ("age".equals(sortBy)) {
            return service.sortByAge(datasetName);
        }

        return "Invalid query";
    }
}