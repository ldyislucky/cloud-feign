package cn.itcast.order.service;

import cn.itcast.order.clients.UserClients;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //String url= "http://localhost:8081/user/"+ order.getUserId();
        String url= "http://userserver/user/"+ order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        // 4.返回
        return order;
    }

    @Autowired
    UserClients userClients;
    public Order queryOrderById_fei(Long orderid){
        Order order = orderMapper.findById(orderid);
        User user = userClients.findId(order.getUserId());
        order.setUser(user);
        return order;

    }
}
