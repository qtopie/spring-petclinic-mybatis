
## SaveOrUpdate
Use `insert into <table> values(...) on duplicate key update` to implement save or update.
Or write this function in service layer.

```java
  @Insert({"INSERT INTO types(id,name) values(#{id}, #{name})", 
      "ON DUPLICATE KEY UPDATE name=#{name}"})
  void save(PetType petType) throws DataAccessException;
```

## One to One / One to Many / Many to One / Many to Many

* One to One/Many

Use association: 

  ```java
  @Result(property = "owner",  column = "owner_id", javaType = Owner.class,
    one=@One(select="org.springframework.samples.petclinic.mapper.OwnerMapper.findById"))
  ```

* One to Many

Use collection: 
```java
  @Result(property = "visits",  column = "id",
      many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.VisitMapper.findByPetId"))
```

* Many to Many

Use collection:
```java
  @Select("SELECT * FROM vets WHERE id = #{id}")
  @Results({
    @Result(property = "id", column = "id"),
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
    @Result(property = "specialties", javaType=Set.class, column = "id",
    many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.SpecialtyMapper.findByVetId")),
  })
  Vet findById(int id) throws DataAccessException;

//-------------------------------------------------------------------------------------

  @Select({"SELECT DISTINCT id, name FROM specialties WHERE id IN(",
    "SELECT specialty_id FROM vet_specialties WHERE vet_id = #{vetId}",
    ")"})
  Set<Specialty> findByVetId(int vetId) throws DataAccessException;
```

Trick to handle child rows:

```xml
	<insert id="save" useGeneratedKeys="true" keyProperty="id"
		parameterType="org.springframework.samples.petclinic.model.Vet">
		INSERT INTO vets
			(id,
			first_name,
			last_name)
		VALUES(
			#{id},
			#{firstName},
			#{lastName}
		)
		ON DUPLICATE KEY UPDATE
			first_name = #{firstName},
			last_name = #{lastName};
		<foreach collection="specialties" item="item" index="index" separator=" ">
			INSERT INTO specialties(id,name) VALUES(#{item.id}, #{item.name})
				ON DUPLICATE KEY UPDATE name = #{item.name};
			INSERT IGNORE INTO vet_specialties(vet_id, specialty_id) VALUES(#{id}, #{item.id});
		</foreach>
	</insert>
```

Here `allowMultiQueries=true` should be enabled in MySQL.
      
Note that the column filed can add more than one parameters to match the method in `select` method      

* For non primitive class, declare the class type explicitly

e.g, `@Result(property = "birthDate",  column = "birth_date", javaType = Date.class)`

```java
@Select("SELECT * FROM pets WHERE id = #{id}")
  @Results({
    @Result(property = "birthDate",  column = "birth_date", javaType = Date.class),
    @Result(property = "type",  column = "type_id", javaType = PetType.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.PetTypeMapper.findById")),
    @Result(property = "owner",  column = "owner_id", javaType = Owner.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.OwnerMapper.findById")),
    @Result(property = "visits",  column = "pet_id",
      many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.VisitMapper.findByPetId")),
  })
  Pet findById(int id) throws DataAccessException;
```

## Reference
* http://www.mybatis.org/mybatis-3/java-api.html  @Select({"SELECT DISTINCT id, name FROM specialties WHERE id IN(",
    "SELECT specialty_id FROM vet_specialties WHERE vet_id = #{vetId}",
    ")"})
  Set<Specialty> findByVetId(int vetId) throws DataAccessException;