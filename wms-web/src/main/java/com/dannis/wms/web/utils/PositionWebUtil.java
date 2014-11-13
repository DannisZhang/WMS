package com.dannis.wms.web.utils;

import com.dannis.wms.dto.PositionDto;
import com.dannis.wms.entity.Position;
import com.dannis.wms.vo.PositionVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Position utility,used to convert DTO to BO and BO to VO
 * Created by:  deng.zhang
 * Created on:  2014-11-10 22:43
 */
public class PositionWebUtil {
  /**
   * Convert Position DTO to BO
   *
   * @param dto position DTO
   * @return position BO
   */
  public static Position convertToBo(PositionDto dto) {
    Position position = new Position();
    position.setId(dto.getId());
    position.setName(dto.getName());
    position.setCode(dto.getCode());
    position.setRemark(dto.getRemark());

    return position;
  }

  /**
   * Convert Position BO to VO
   *
   * @param position Position BO
   * @return Position VO
   */
  public static PositionVo convertToVo(Position position) {
    PositionVo vo = new PositionVo();
    vo.setId(position.getId());
    vo.setName(position.getName());
    vo.setCode(position.getCode());
    vo.setRemark(position.getRemark());
    vo.setCreatedOn(position.getCreatedOn());
    vo.setCreatedBy(position.getCreatedBy());
    vo.setModifiedOn(position.getModifiedOn());
    vo.setModifiedBy(position.getModifiedBy());

    return vo;
  }

  /**
   * Convert position BO list to VO list
   *
   * @param positions position BO list
   * @return position VO list
   */
  public static List<PositionVo> convertToVos(List<Position> positions) {
    List<PositionVo> vos = new ArrayList<>();
    if (null != positions && positions.size() > 0) {
      for (Position position : positions) {
        vos.add(convertToVo(position));
      }
    }
    return vos;
  }
}
