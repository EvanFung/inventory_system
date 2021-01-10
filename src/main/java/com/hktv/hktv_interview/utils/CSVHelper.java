package com.hktv.hktv_interview.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hktv.hktv_interview.model.Inventory;
import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.model.Stock;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
//    static String[] HEADERs = { "Id", "Title", "Description", "Published" };


    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Product> csvToProducts(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Product> products = new ArrayList<Product>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Product product = new Product();
                product.setCode(csvRecord.get( "code" ));
                product.setName(csvRecord.get( "name" ));
                product.setWeight(Integer.parseInt(csvRecord.get( "weight" )));
                product.setType(csvRecord.get("type"));
                product.setUnit(csvRecord.get("unit"));
                product.setCreateAt(new Date());
                products.add(product);
            }
            return products;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<Stock> csvToStock(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Stock> stocks = new ArrayList<Stock>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Stock stock = new Stock();
                stock.setWarehouseId(Integer.parseInt(csvRecord.get("warehouse_id")));
                stock.setProductId(Integer.parseInt(csvRecord.get("product_id")));
                stock.setOperator(csvRecord.get("operator"));
                stock.setQty(Integer.parseInt(csvRecord.get("qty")));
                stock.setCreateAt(new Date());
                stock.setType(csvRecord.get("type"));
                stocks.add(stock);
            }
            return stocks;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
