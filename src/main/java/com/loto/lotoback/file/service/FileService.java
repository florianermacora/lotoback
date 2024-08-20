package com.loto.lotoback.file.service;


import com.loto.lotoback.premtirage.entity.PremTirageEntity;
import com.loto.lotoback.premtirage.service.PremTirageService;
import com.loto.lotoback.sectirage.entity.SecTirageEntity;
import com.loto.lotoback.sectirage.service.SecTirageService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.loto.lotoback.file.enums.HeaderCsvNameEnum.*;

@Service
public class FileService {

    public final PremTirageService premTirageService;
    public final SecTirageService secTirageService;

    public FileService(PremTirageService premTirageService, SecTirageService secTirageService) {
        this.premTirageService = premTirageService;
        this.secTirageService = secTirageService;
    }

    public boolean hasCsvFormat(MultipartFile file) {
        return "text/csv".equals(file.getContentType());
    }

    public void processAndSaveData(MultipartFile file) {

        try {
            csvToData(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void csvToData(InputStream inputStream) {
        List<PremTirageEntity> tirageList1 = new ArrayList<>();
        List<SecTirageEntity> tirageList2 = new ArrayList<>();
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            CSVParser csvParser =
                    new CSVParser(fileReader, CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(';').withTrim());
            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                LocalDate localDate = LocalDate.parse(record.get(DATE_TIRAGE.getNameBoule()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                List<Integer> sortListTirage1 = this.getDataToSortArray(record, BOULE1.getNameBoule(), BOULE2.getNameBoule(),
                        BOULE3.getNameBoule(), BOULE4.getNameBoule(), BOULE5.getNameBoule(), BOULECOMP.getNameBoule());
                PremTirageEntity tirage =
                        new PremTirageEntity(sortListTirage1.get(0), sortListTirage1.get(1), sortListTirage1.get(2),
                                sortListTirage1.get(3), sortListTirage1.get(4), sortListTirage1.get(5), localDate);
                tirageList1.add(tirage);

                List<Integer> sortListTirage2 = this.getDataToSortArray(record, BOULE1_2.getNameBoule(), BOULE2_2.getNameBoule(),
                        BOULE3_2.getNameBoule(), BOULE4_2.getNameBoule(), BOULE5_2.getNameBoule());
                SecTirageEntity tirage2 =
                        new SecTirageEntity(sortListTirage2.get(0), sortListTirage2.get(1), sortListTirage2.get(2),
                                sortListTirage2.get(3), sortListTirage2.get(4), localDate);

                tirageList2.add(tirage2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.premTirageService.saveTiragesList(tirageList1);
        this.secTirageService.saveTiragesList(tirageList2);
    }

    private List<Integer> getDataToSortArray(CSVRecord record, String data1, String data2, String data3, String data4, String data5) {
        List<Integer> sortArray = new ArrayList<>();
        sortArray.add(Integer.parseInt(record.get(data1)));
        sortArray.add(Integer.parseInt(record.get(data2)));
        sortArray.add(Integer.parseInt(record.get(data3)));
        sortArray.add(Integer.parseInt(record.get(data4)));
        sortArray.add(Integer.parseInt(record.get(data5)));
        Collections.sort(sortArray);
        return sortArray;
    }

    private List<Integer> getDataToSortArray(CSVRecord record, String data1, String data2, String data3, String data4, String data5, String data6) {
        List<Integer> sortArray = getDataToSortArray(record, data1, data2, data3, data4, data5);
        sortArray.add(Integer.parseInt(record.get(data6)));
        return sortArray;
    }
}
