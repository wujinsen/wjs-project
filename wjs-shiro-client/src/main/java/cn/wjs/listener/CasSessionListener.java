package cn.wjs.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CasSessionListener implements SessionListener {

    private Logger logger = LoggerFactory.getLogger(CasSessionListener.class);

    @Override
    public void onStart(Session session) {
        logger.debug("新会话 {}",session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.debug("会话结束 {}",session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.debug("会话过期 {}",session.getId());
    }
}
