package web.calendar.schedule.dao;

import web.calendar.schedule.bean.RepeatPattren;

public interface RepeatPatternDao {
	RepeatPattren selectRepaPattren(Integer repeatId);
}
