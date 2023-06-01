package web.calendar.tag.dao;

public interface TagDefaultDao {
	int insertAllByMemberNo(Integer memberNo, Integer tagId, String tagColor); // 新增所有標籤資料給某會員
	
	int selectIdAndName(Integer memberNo);
}
