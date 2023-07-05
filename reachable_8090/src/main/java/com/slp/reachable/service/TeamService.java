package com.slp.reachable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.slp.reachable.model.domain.Team;
import com.slp.reachable.model.domain.User;
import com.slp.reachable.model.dto.TeamQuery;
import com.slp.reachable.model.request.TeamJoinRequest;
import com.slp.reachable.model.request.TeamQuitRequest;
import com.slp.reachable.model.request.TeamUpdateRequest;
import com.slp.reachable.model.vo.TeamUserVO;


import java.util.List;

/**
 *
 */
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     *
     * @param team
     * @param userId
     * @return
     */
    long addTeam(Team team, long userId);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    List<Team> listTeamsPublicOrPrivate(TeamQuery teamQuery);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
