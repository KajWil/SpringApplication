package bdbt_bada_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import java.beans.BeanProperty;
import java.util.List;
@Repository
public class KsiazkiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public KsiazkiDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Ksiazki> list() {
        String sql = "SELECT * FROM KSIAZKI";
        List<Ksiazki> listKsiazki = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ksiazki.class));
        return listKsiazki;
    }
    public void saveKsiazki(Ksiazki linie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ksiazki").usingColumns("id_ksiazki", "tytul", "isbn", "id_biblioteki", "id_wydawnictwa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(linie);
        insertActor.execute(param);
    }
    public Ksiazki get(int id_ksiazki){
        Object[] args = {id_ksiazki};
        String sql = "SELECT * FROM KSIAZKI WHERE ID_KSIAZKI = " + args[0];
        Ksiazki ksiazka = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Ksiazki.class));
        return ksiazka;
    }
    public void updateKsiazki(Ksiazki ksiazki) {
        String sql = "UPDATE KSIAZKI SET tytul=:tytul, isbn=:isbn, id_biblioteki=:id_biblioteki, id_wydawnictwa=:id_wydawnictwa";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ksiazki);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    public void deleteKsiazki(int id_ksiazki) {
        String sql = "DELETE FROM ksiazki WHERE id_ksiazki=:id_ksiazki";
        jdbcTemplate.update(sql, id_ksiazki);
    }
}