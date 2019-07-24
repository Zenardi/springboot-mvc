package guru.springframework.services;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Product;

/**
 * ProductServiceJpaDaoImplTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest {
    private ProductService productService;
    /**
     * @param productService the productService to set
     */
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void testListMethod() throws Exception{
        List<Product> products = (List<Product>) productService.listAll();
        assert products.size() == 5;
    }
}