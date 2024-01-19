create database bootcamp_exercise4;
show databases;
use bootcamp_exercise4;

create table players (
	player_id integer not null unique,
    group_id integer not null
);

create table matches (
	match_id integer not null unique,
    first_player integer not null,
    second_player integer not null,
    first_score integer not null,
    second_score integer not null
);

-- compute the winner in each group
-- winner -> scored max points within the group, with lowest ID
insert into players values 
	(20,2),
    (30,1),
    (40,3),
    (45,1),
    (50,2),
    (65,1);

insert into matches values
(1,30,45,10,12),
(2,20,50,5,5),
(13,65,45,10,10),
(5,30,65,3,15),
(42,45,65,8,4);

-- find the max score for selected group_id
-- group by group_id, score
with 
	player_table as (
		select p.group_id , m.first_player as player_id, sum( m.first_score) as scores
		from matches m
		left join players p
		on m.first_player = p.player_id
		group by p.group_id ,m.first_player
		union
		select p1.group_id , m1.second_player as player_id,  sum(m1.second_score) as scores
		from matches m1
		left join players p1
		on m1.second_player = p1.player_id
		group by p1.group_id ,m1.second_player
    ), sum_up_table as (
		select pt.group_id ,pt.player_id, sum(pt.scores)  as sum_up_scores
		from player_table pt
		group by pt.group_id ,pt.player_id
    ), max_scores_table as (
		select st.group_id, max(st.sum_up_scores) as max_score
		from sum_up_table st
		group by st.group_id
    ), groupped_table as (
		select ft.group_id,min(st.player_id) as player_id
		from max_scores_table ft
		left join sum_up_table st
		on ft.group_id = st.group_id and ft.max_score = st.sum_up_scores
		group by ft.group_id
    )
select p3.group_id,
case when gt.group_id is null then p3.player_id else gt.player_id End as player_id
from players p3
left join groupped_table gt
on p3.group_id = gt.group_id
group by p3.group_id, player_id
order by p3.group_id asc;

