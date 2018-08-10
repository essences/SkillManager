package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.JukouListBean;
import bean.SankashaListBean;
import dao.Dao;
import dao.JukouDao;
import vo.KenshujukouVo;

public class JukouService
{
       public SankashaListBean getKenshuSankashaList(String kenshuJissekiid  )
        {
            SankashaListBean bean = new SankashaListBean();
            try ( Connection con = Dao.getConnection(); )
            {
                JukouDao dao = new JukouDao(con);

                dao.getSankashaList( bean, kenshuJissekiid );

                if( bean.size() != 0 )
                {
                    bean.setTitle(			bean.get(0).getTitle()			);
                    bean.setKaisaidate(		bean.get(0).getKaisaidate()		);
                    bean.setKaisaidate2(	bean.get(0).getKaisaidate2()		);
                    bean.setKaisaidate3(	bean.get(0).getKaisaidate3()		);
                    bean.setNumdays(		bean.get(0).getNumdays()	);
                }

            }
            catch( SQLException e )
            {
                e.printStackTrace();
                throw new RuntimeException( e );
            }

            return bean;
        }


        public JukouListBean getJukouList(String shainid  )
        {
            JukouListBean bean = new JukouListBean();
            try ( Connection con = Dao.getConnection(); )
            {
                JukouDao dao = new JukouDao(con);

                dao.getJukouList( bean, shainid );

                if( bean.size() != 0 )
                {
                    bean.setEmployee_no(			bean.get(0).getEmployee_no());
                    bean.setEmployee_family_name( 	bean.get(0).getEmployee_family_name());
                    bean.setEmployee_first_name( 	bean.get(0).getEmployee_first_name());
                    bean.setNenji(					bean.get(0).getNenji());
                    bean.setChuto_ninasinenji(		(int)bean.get(0).getChuto_ninasinenji());
                }
            }
            catch( SQLException e )
            {
                e.printStackTrace();
                throw new RuntimeException( e );
            }

            return bean;
        }

        //	参加者を登録して表示データを取得する
        public SankashaListBean registSankasha(String kenshujissekiId, List<KenshujukouVo> list)
        {
            SankashaListBean bean = new SankashaListBean();
            try ( Connection con = Dao.getConnection(); )
            {
                JukouDao dao = new JukouDao(con);

                dao.registSankasha( kenshujissekiId, list );

                dao.getSankashaList( bean, kenshujissekiId );

                if( bean.size() != 0 )
                {
                    bean.setTitle(			bean.get(0).getTitle()			);
                    bean.setKaisaidate(		bean.get(0).getKaisaidate()		);
                    bean.setKaisaidate2(	bean.get(0).getKaisaidate2()		);
                    bean.setKaisaidate3(	bean.get(0).getKaisaidate3()		);
                    bean.setNumdays(		bean.get(0).getNumdays()	);
                }

            }
            catch( SQLException e )
            {
                e.printStackTrace();
                throw new RuntimeException( e );
            }

            return bean;
        }


        public SankashaListBean updateKenshuSankashaList(String kenshujissekiId, List<KenshujukouVo> list) {
            SankashaListBean bean = new SankashaListBean();
            try ( Connection con = Dao.getConnection(); )
            {
                JukouDao dao = new JukouDao(con);

                dao.updateSankasha(  list );

                dao.getSankashaList( bean, kenshujissekiId );

                if( bean.size() != 0 )
                {
                    bean.setTitle(			bean.get(0).getTitle()			);
                    bean.setKaisaidate(		bean.get(0).getKaisaidate()		);
                    bean.setKaisaidate2(	bean.get(0).getKaisaidate2()		);
                    bean.setKaisaidate3(	bean.get(0).getKaisaidate3()		);
                    bean.setNumdays(		bean.get(0).getNumdays()	);
                }

            }
            catch( SQLException e )
            {
                e.printStackTrace();
                throw new RuntimeException( e );
            }

            return bean;        }

}
