package com.atguigu.mybatisplus;
import com.atguigu.mybatisplus.entity.Stocklist;
import com.atguigu.mybatisplus.entity.Tradehistory;
import com.atguigu.mybatisplus.mapper.StocklistMapper;
import com.atguigu.mybatisplus.mapper.TradehistoryMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.StocklistService;
import com.atguigu.mybatisplus.service.TradehistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StocklistMapper stocklistMapper;
    @Autowired
    private TradehistoryMapper tradehistoryMapper;


    @Autowired
    private StocklistService stocklistService;
    @Autowired
    private TradehistoryService tradehistoryService;


    @Test
    public void 选择全部(){
        /* 查全部 mapper selectList */
        List<Tradehistory> list = tradehistoryMapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    public void 插入单条insert(){
        /*  增加单条记录 mapper  */
        Stocklist sl = new Stocklist();
        sl.setCode("900002");
        sl.setName("aaa");
        int rt = stocklistMapper.insert(sl);
        System.out.println(rt);
    }
    @Test
    public void 插入单条save(){
        /*  增加单条记录  service  */
        Stocklist sl = new Stocklist();
        sl.setCode("002467");
        sl.setName("二六三");
        Boolean rt = stocklistService.save(sl);
        System.out.println(rt.toString());
    }
    @Test
    public void 插入或更新(){
        /*  增加单条记录  service  */
        Stocklist sl = new Stocklist();
        sl.setCode("002467");
        sl.setName("二六1三");
        Boolean rt = stocklistService.saveOrUpdate(sl);
        System.out.println(rt.toString());
    }

    @Test
    public void testDeleteByMap(){
        /*  map删除  */
        Map<String,Object> map = new HashMap<>();
        map.put("name","aaa");
        int rt = stocklistMapper.deleteByMap(map);
        System.out.println(rt);
    }
    @Test
    public void testCount(){
        /*  map 总数  */
       long cnt1 = stocklistMapper.selectCount(null);
       long cnt2 = stocklistService.count();
       System.out.println(cnt1);
       System.out.println(cnt2);
    }

    @Test
    public void 批量添加(){
        /*  批量添加  */
        List<Tradehistory> list = new ArrayList<>();
        for(int i = 1; i < 10 ; i++){
            Tradehistory th = new Tradehistory();
            long ii =  Long.valueOf(i);
//            th.setId(ii);
            th.setCode("60106" + Integer.toString(i));
            th.setName("nanme-"+ Integer.toString(i));
            th.setContent("content-" +  Integer.toString(i));
            list.add(th);
        }
        boolean b = tradehistoryService.saveBatch(list);
        System.out.println(b);
    }
}
