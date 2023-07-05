package com.slp.reachable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.slp.reachable.service.UserTeamService;
import com.slp.reachable.model.domain.UserTeamRelation;
import com.slp.reachable.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeamRelation>
        implements UserTeamService {

}




