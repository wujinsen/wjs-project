package cn.wjs.service;

import cn.wjs.domain.Stock;
import cn.wjs.mapper.StockMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockMapper stockMapper;

    @Override
    public boolean decrease(Long skuId) {
        Stock stock = stockMapper.selectOne(new LambdaQueryWrapper<Stock>().eq(Stock::getSkuId, skuId));
        int stockNum = stock.getStockNum() - 1;
        stock.setStockNum(stockNum);
        stockMapper.updateById(stock);
        stock = new Stock();
        stock.getId().equals("q111");
        return true;
    }

}
