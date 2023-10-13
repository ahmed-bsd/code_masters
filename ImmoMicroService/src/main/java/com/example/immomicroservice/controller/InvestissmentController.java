package com.example.immomicroservice.controller;

import com.example.immomicroservice.Repository.InvestissmentRepository;
import com.example.immomicroservice.Service.InvestissmentService;
import com.example.immomicroservice.entities.EstimatePrice;
import com.example.immomicroservice.entities.Investissement;
import com.example.immomicroservice.entities.LoanResult;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/public/investisement")
public class InvestissmentController {

    @Autowired
    InvestissmentService investismentService;
    @Autowired
    InvestissmentRepository investismentRepository;

    @PostMapping("/upload")
    public String uploadDateSet(@RequestParam("file") MultipartFile file) throws IOException {
        List<Investissement> dataSets = new ArrayList<>();
        InputStream inputStream=file.getInputStream();
        CsvParserSettings setiing = new CsvParserSettings();
        setiing.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setiing);
        List<Record> listRecords = parser.parseAllRecords(inputStream);
        listRecords.forEach(record -> {
            Investissement ds = new Investissement();
            ds.setCategory(record.getString("category"));
            ds.setRoomsCount(record.getString("room_count"));
            ds.setBathroomCount(record.getString("bathroom_count"));
            ds.setSize(record.getString("size"));
            ds.setType(record.getString("type"));
            ds.setPrice(Float.parseFloat(record.getString("price")));
            ds.setCity(record.getString("city"));
            ds.setRegion(record.getString("region"));
            ds.setLogPrice(Float.parseFloat(record.getString("log_price")));
            dataSets.add(ds);
        });
        investismentRepository.saveAll(dataSets);
        return "upload successful !!";
    }
    @PostMapping("/estimation")
    public EstimatePrice estimatePrice(@RequestBody Investissement investisment) {
        return investismentService.estimatePrice(investisment);

    }

    @GetMapping("/simulateurFin")
    public LoanResult simulateurfin(@RequestParam("Propertyprice") float Propertyprice,
                                    @RequestParam("loanTermInYears")int loanTermInYears, @RequestParam("autoFinanced") double autoFinanced){

        return investismentService.finCalculator(Propertyprice,loanTermInYears,autoFinanced);
    }







}
