package com.pet.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pet.model.Card;
import com.pet.model.Payment;
import com.pet.model.Schedule;

public interface CardMapper {
	public void insertCard(Card c);
}