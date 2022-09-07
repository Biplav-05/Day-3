package com.example.day_3.service;

import com.example.day_3.Model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private List<EmployeeModel> doThat() {
        List<EmployeeModel> listModel = new ArrayList<EmployeeModel>();
                listModel.add(new EmployeeModel(55, "aa", "bb", "cc","aa is added"));
    return listModel;
    }

private  List<EmployeeModel> list = doThat();

    public List<EmployeeModel> getAllItems()
    {
        return list;
    }
    public void addItems(EmployeeModel employeeModel) {

      list.add(employeeModel);
      //return "item added ";
    }

    public void deleteEmployeeFast(Integer id) {
        list=list.stream().filter(ids->ids.getId()!=id).collect(Collectors.toList());
    }
}
