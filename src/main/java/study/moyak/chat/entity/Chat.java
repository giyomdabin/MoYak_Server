package study.moyak.chat.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity (name = "chatroom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String room_name;

    @Lob
    @Column(columnDefinition = "MEDIUMTEXT")  // 명시적으로 TEXT 타입으로 지정
    private String all_image;

    @CreationTimestamp
    private Timestamp createDate;

    @OneToMany(mappedBy = "chatroom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EachPill> eachPills;
}
