package Client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import SharedTypes.StructureOfProductDB;

public class MyTableModel implements TableModel {
 
        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
 
        private ArrayList<StructureOfProductDB> structureOfProductDB;
 
        public MyTableModel(ArrayList<StructureOfProductDB> structureOfProductDB) {
            this.structureOfProductDB = structureOfProductDB;
        }
 
        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }
 
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }
 
        public int getColumnCount() {
            return 5;
        }
 
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
            case 0:
                return "Назва";
            case 1:
                return "Виробник";
            case 2:
                return "Опис";
                case 3:
                return "Кількість";
            case 4:
                return "Ціна";
        }
            return "";
        }
 
        public int getRowCount() {
            return structureOfProductDB.size();
        }
 
        public Object getValueAt(int rowIndex, int columnIndex) {
        	StructureOfProductDB structureOfProduct = structureOfProductDB.get(rowIndex);
            switch (columnIndex) {
            case 0:
                return structureOfProduct.getProductName();
            case 1:
                return structureOfProduct.getProductManufacturer();
            case 2:
                return structureOfProduct.getProductDescription();
                case 3:
                return structureOfProduct.getProductAmount();
            case 4:
                return structureOfProduct.getProductPrice();
            }
            return "";
        }
 
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
 
        public void removeTableModelListener(TableModelListener listener) {
            listeners.remove(listener);
        }
 
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
 
        }
 
    }
