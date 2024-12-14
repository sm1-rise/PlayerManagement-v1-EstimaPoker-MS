package br.com.samuel.martins.sm1_rise.playersmanagement_v1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity (name = "player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(min = 3, max = 30)
    private String username;

    @Column(unique = true)
    @NotBlank
    private String email;

    private String avatarUrl;

    @NotNull
    private String passwordHash;

    private String authProvider;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private UUID activeRoomId;

    @ElementCollection
    @CollectionTable(name = "player_rooms", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "room_id")
    private Set<UUID> roomsParticipated;

    @Min(0)
    private int votesCast;

    @Min(0)
    private int storiesContributed;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime lastActiveAt;

    private String preferredDeck;

    private boolean notificationsEnabled;

    private String themePreference;
}
