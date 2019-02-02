package Database;

import BussinessLogic.Cat;
import BussinessLogic.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements Repository<Product> {
    private Map<Long, Product> productCollection;

    public ProductRepository(){
        productCollection = new HashMap<>();
    }


    @Override
    public void save(Product item) {
        productCollection.put(item.getId(), item);
    }


    @Override
    public Product findById(Long id) throws ItemNotFoundException {

        if(!productCollection.containsKey(id)){
            throw new ItemNotFoundException("Product with such ID doesn't exist.");
        }

        return productCollection.get(id);
    }


    @Override
    public void delete(Long id) throws ItemNotFoundException {

        if(!productCollection.containsKey(id)){
            throw new ItemNotFoundException("Product with such ID doesn't exist.");
        }

        productCollection.remove(id);
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(productCollection.values());
    }


    @Override
    public List<Product> findByCategory(Cat category) {
        List<Product> outputList = new ArrayList<>();

        productCollection.forEach((k,v) -> {
            if(category == v.getCategory()){
                outputList.add(v);
            }
        });

        return outputList;
    }
}
