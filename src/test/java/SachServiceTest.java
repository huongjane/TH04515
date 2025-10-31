import org.example.Entity.Sach;
import org.example.Service.SachService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SachServiceTest {

    private SachService sachService;
    private Sach sach;

    @BeforeEach
    void setUp() {
        sachService = new SachService();
        sach = new Sach("S01", "Toán", "Nam Cao", 2000, 50000f);
    }

    @Test
    void testSuaSach_ValidData() {
        sachService.suaSach(sach, "S02", "Văn học", "Nguyễn Du", 2020, 100000f);
        Assertions.assertEquals("S02", sach.getMaSach());
        Assertions.assertEquals("Văn học", sach.getTenSach());
        Assertions.assertEquals("Nguyễn Du", sach.getTacGia());
        Assertions.assertEquals(2020, sach.getNamXuatBan());
        Assertions.assertEquals(100000f, sach.getGia());
    }

    @Test
    void testSuaSach_EmptyField_ShouldThrowException() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sachService.suaSach(sach, "", "Văn", "Nguyễn Du", 2020, 10000f);
        });
        Assertions.assertTrue(e.getMessage().contains("không được để trống"));
    }

    @Test
    void testSuaSach_NamXuatBanBeHon1990_ShouldThrowException() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sachService.suaSach(sach, "S01", "Lý", "Tác giả", 1989, 20000f);
        });
        Assertions.assertTrue(e.getMessage().contains("Năm xuất bản"));
    }

    @Test
    void testSuaSach_NamXuatBanLonHon2025_ShouldThrowException() {
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sachService.suaSach(sach, "S01", "Hóa", "Tác giả", 2026, 20000f);
        });
        Assertions.assertTrue(e.getMessage().contains("Năm xuất bản"));
    }

    @Test
    void testSuaSach_NamXuatBanBien1990_Valid() {
        sachService.suaSach(sach, "S03", "Anh", "Tác giả", 1990, 25000f);
        Assertions.assertEquals(1990, sach.getNamXuatBan());
    }
}
