package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    //static으로 생성했으니까 new로 생성해도 하나로 존재
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //싱글톤으로(스프링쓰면 싱글톤 보장해줘서 쓸 필요없는데 이거는 스프링이 아니라서 해줌)
    private static final MemberRepository instance = new MemberRepository();

    //무조건 이 메서드로 조회를 해야함
    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤으로 만들 때는 아무나 생성하지 못하도록 private으로 생성자를 막아야함
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}



