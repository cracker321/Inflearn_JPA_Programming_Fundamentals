package hellojpa;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") //'양방향 연관관계와 연관관계의 주인 1- 기본'강 09:00~
                                  //'양방향 객체 연관관계 매핑'
                                  //- 'mappedBy = team': 반대평 연관관계인 'Member 객체'의 '필드 team'과 '연결(매핑)'되어 있다 라는 뜻
                                  //- '양방향 연관관계 매핑의 주인'은 'Member 객체의 필드 team'이다!
                                  //   왜냐하면, '주인'은 '외래 키'가 있는 곳이기 때문! 강의 pdf자료에 상세 필기해놨음
                                  //   현재 이 필드는 연관관계의 주인이 아니기 때문에, 이 '필드 members'를 통해
                                  //   회원을 추가, 삭제하는 등의 Create, Update, Delete(아마도)는 할 수 없다.
                                  //   여기서 그렇게 코드 작성해서 시도해봤자, DB에 아무런 영향도 가지 않는다!

    private List<Member> members = new ArrayList<>(); //- 'List<Member>': '양방향 객체 연관관계 매핑'
                                                      //                  '회원(Member)'는 '다수(N)'이기에 'List' 씀.
                                                      //- 'new ArrayList<>()': 'ArrayList로 초기화'. 관례임.
                                                      //                    이래야, 'add'할 때, 'null point exception'안 뜸.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}