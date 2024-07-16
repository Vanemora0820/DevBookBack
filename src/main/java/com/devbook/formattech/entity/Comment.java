    package com.devbook.formattech.entity;

    import jakarta.persistence.*;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import java.util.Date;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "comment")
    public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int id;
        private String comm_content;
        private String comm_media_url;
        private String comm_picture_url;
        private boolean active = true;

        @CreationTimestamp
        private Date created_at;
        @UpdateTimestamp
        private Date updated_at;
    }
