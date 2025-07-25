package automation.testsuite;

import org.testng.annotations.Test;

public class BTVN_Day7 {
    @Test
    public void Nhanven() {
        String[] ten = {"Nguyễn Công Trứ", "Bùi Viết Xuân", "Đinh Tiên Hoàng", "Nguyễn Xuân Hạnh", "Hoàng Thị Loan"};
        System.out.println("Danh sách nhân viên là:");
        for (int x = 0; x < ten.length; x++) {
            System.out.println(ten[x]);
        }
    }
}
