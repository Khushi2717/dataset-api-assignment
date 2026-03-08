package com.example.datasetapi.service;

import com.example.datasetapi.model.DatasetRecord;
import com.example.datasetapi.repository.DatasetRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DatasetService {

    private final DatasetRepository repository;

    public DatasetService(DatasetRepository repository) {
        this.repository = repository;
    }

    public DatasetRecord saveRecord(String datasetName, DatasetRecord record) {
        record.setDatasetName(datasetName);
        return repository.save(record);
    }

    public Map<String, List<DatasetRecord>> groupByDepartment(String datasetName) {
        List<DatasetRecord> records = repository.findByDatasetName(datasetName);

        return records.stream()
                .collect(Collectors.groupingBy(DatasetRecord::getDepartment));
    }

    public List<DatasetRecord> sortByAge(String datasetName) {
        List<DatasetRecord> records = repository.findByDatasetName(datasetName);

        records.sort(Comparator.comparing(DatasetRecord::getAge));
        return records;
    }
}