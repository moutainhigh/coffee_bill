package cn.sisyphe.coffee.bill.domain.base;

import cn.sisyphe.coffee.bill.domain.base.model.Bill;
import cn.sisyphe.coffee.bill.domain.delivery.DeliveryBillService;
import cn.sisyphe.coffee.bill.domain.headquarters.HeadQuarterBillService;
import cn.sisyphe.coffee.bill.domain.purchase.PurchaseBillService;

/**
 * Created by heyong on 2017/12/19 17:19
 * Description: 单据服务工厂类
 *
 * @author heyong
 */
public class BillServiceFactory {


    /**
     * 创建单据服务
     *
     * @param bill
     * @return
     */
    public AbstractBillService createBillService(Bill bill) {
        AbstractBillService billService = null;

        switch (bill.getBillType()) {
            case PURCHASE:
                billService = new PurchaseBillService(bill);
                break;
            case DELIVERY:
                billService = new DeliveryBillService(bill);
                break;
            case PLAN:
                billService = new HeadQuarterBillService(bill);
                break;
            default:
                break;
        }

        return billService;
    }

}