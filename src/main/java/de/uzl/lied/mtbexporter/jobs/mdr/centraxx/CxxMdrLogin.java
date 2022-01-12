package de.uzl.lied.mtbexporter.jobs.mdr.centraxx;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import de.uzl.lied.mtbexporter.model.mdr.centraxx.MdrToken;
import de.uzl.lied.mtbexporter.settings.CxxMdrSettings;

public class CxxMdrLogin {
    
    public static CxxMdrSettings login(CxxMdrSettings mdr) {
     
        RestTemplate rt = new RestTemplate();
        rt.getInterceptors().add(new BasicAuthenticationInterceptor(mdr.getBasicUsername(), mdr.getBasicPassword()));
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.set("grant_type", "password");
        form.set("scope", "anyscope");
        form.set("username", mdr.getUsername());
        form.set("password", mdr.getPassword());
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mdr.getUrl() + "/oauth/token");
        builder.queryParams(form);
        MdrToken token = rt.postForObject(builder.build().encode().toUri(), null, MdrToken.class);
        mdr.setToken(token.getAccessToken(), token.getExpiresIn());

        return mdr;
    }

}
