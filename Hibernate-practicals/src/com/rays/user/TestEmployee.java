package com.rays.user;

import java.util.Iterator;
import java.util.List;

public class TestEmployee {
	
	
	public static void main(String[] args) {
	     //add();
		//update();
		//search();
	    FindByPk();
	}

	private static void FindByPk() {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		
		dto = model.FindByPk(1);
		
		System.out.print(dto.getId());
		System.out.print("\t"+dto.getName());
		System.out.print("\t"+dto.getAddress());
		System.out.print("\t"+dto.getSalary());
	}

	private static void search() {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		
		List list = model.search(dto, 0, 0);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			dto = (EmployeeDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t"+dto.getName());
			System.out.print("\t"+dto.getAddress());
			System.out.print("\t"+dto.getSalary());
			System.out.println();
		}
		
	}

	private static void update() {
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		 
		dto.setId(1);
		dto.setName("Aman");
		dto.setAddress("Indore");
		dto.setSalary(13000);
		model.update(dto);
		
	}

	private static void add() {
		
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		
		dto.setId(1);
		dto.setName("Aman");
		dto.setAddress("Indore");
		dto.setSalary(12000);
		  model.add(dto);
	
	}

}
